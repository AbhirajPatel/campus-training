

"use strict";

function makeCircle(points) {
	// Clone list to preserve the caller's data, do Durstenfeld shuffle
	var shuffled = points.slice();
	for (var i = points.length - 1; i >= 0; i--) {
		var j = Math.floor(Math.random() * (i + 1));
		j = Math.max(Math.min(j, i), 0);
		var temp = shuffled[i];
		shuffled[i] = shuffled[j];
		shuffled[j] = temp;
	}
	
	// Progressively add points to circle or recompute circle
	var c = null;
	for (var i = 0; i < shuffled.length; i++) {
		var p = shuffled[i];
		if (c == null || !isInCircle(c, p))
			c = makeCircleOnePoint(shuffled.slice(0, i + 1), p);
	}
	return c;
}


// One boundary point known
function makeCircleOnePoint(points, p) {
	var c = {x: p.x, y: p.y, r: 0};
	for (var i = 0; i < points.length; i++) {
		var q = points[i];
		if (!isInCircle(c, q)) {
			if (c.r == 0)
				c = makeDiameter(p, q);
			else
				c = makeCircleTwoPoints(points.slice(0, i + 1), p, q);
		}
	}
	return c;
}


// Two boundary points known
function makeCircleTwoPoints(points, p, q) {
	var circ = makeDiameter(p, q);
	var left = null;
	var right = null;
	
	// For each point not in the two-point circle
	points.forEach(function(r) {
		if (isInCircle(circ, r))
			return;
		
		// Form a circumcircle and classify it on left or right side
		var cross = crossProduct(p.x, p.y, q.x, q.y, r.x, r.y);
		var c = makeCircumcircle(p, q, r);
		if (c == null)
			return;
		else if (cross > 0 && (left == null || crossProduct(p.x, p.y, q.x, q.y, c.x, c.y) > crossProduct(p.x, p.y, q.x, q.y, left.x, left.y)))
			left = c;
		else if (cross < 0 && (right == null || crossProduct(p.x, p.y, q.x, q.y, c.x, c.y) < crossProduct(p.x, p.y, q.x, q.y, right.x, right.y)))
			right = c;
	});
	
	// Select which circle to return
	if (left == null && right == null)
		return circ;
	else if (left == null)
		return right;
	else if (right == null)
		return left;
	else
		return left.r <= right.r ? left : right;
}


function makeCircumcircle(p0, p1, p2) {
	// Mathematical algorithm from Wikipedia: Circumscribed circle
	var ax = p0.x, ay = p0.y;
	var bx = p1.x, by = p1.y;
	var cx = p2.x, cy = p2.y;
	var ox = (Math.min(ax, bx, cx) + Math.max(ax, bx, cx)) / 2;
	var oy = (Math.min(ay, by, cy) + Math.max(ay, by, cy)) / 2;
	ax -= ox; ay -= oy;
	bx -= ox; by -= oy;
	cx -= ox; cy -= oy;
	var d = (ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) * 2;
	if (d == 0)
		return null;
	var x = ox + ((ax * ax + ay * ay) * (by - cy) + (bx * bx + by * by) * (cy - ay) + (cx * cx + cy * cy) * (ay - by)) / d;
	var y = oy + ((ax * ax + ay * ay) * (cx - bx) + (bx * bx + by * by) * (ax - cx) + (cx * cx + cy * cy) * (bx - ax)) / d;
	var ra = distance(x, y, p0.x, p0.y);
	var rb = distance(x, y, p1.x, p1.y);
	var rc = distance(x, y, p2.x, p2.y);
	return {x: x, y: y, r: Math.max(ra, rb, rc)};
}


function makeDiameter(p0, p1) {
	var x = (p0.x + p1.x) / 2;
	var y = (p0.y + p1.y) / 2;
	var r0 = distance(x, y, p0.x, p0.y);
	var r1 = distance(x, y, p1.x, p1.y);
	return {x: x, y: y, r: Math.max(r0, r1)};
}


/* Simple mathematical functions */

var MULTIPLICATIVE_EPSILON = 1 + 1e-14;

function isInCircle(c, p) {
	return c != null && distance(p.x, p.y, c.x, c.y) <= c.r * MULTIPLICATIVE_EPSILON;
}


// Returns twice the signed area of the triangle defined by (x0, y0), (x1, y1), (x2, y2).
function crossProduct(x0, y0, x1, y1, x2, y2) {
	return (x1 - x0) * (y2 - y0) - (y1 - y0) * (x2 - x0);
}


function distance(x0, y0, x1, y1) {
	return Math.sqrt((x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1));
}

var POINT_RADIUS = 4;
var CIRCLE_COLOR = "#E0E0E0";
var POINT_COLOR  = "#000000";


/* Global state */

var canvasElem = document.getElementById("canvas");
var canvasPoints = [];
var canvasCircle = null;
var suppressContextMenu = false;
var dragPointIndex = -1;


/* Event handlers and UI functions */

canvasElem.onmousedown = function(ev) {
	var x = ev.offsetX;
	var y = ev.offsetY;
	var nearest = findNearestPoint(x, y);
	
	// Left mouse button: Add or move point
	if (ev.button == 0) {
		if (nearest.dist <= POINT_RADIUS + 2) {
			// Start moving existing point
			dragPointIndex = nearest.index;
		} else {
			// Add point and start moving it
			dragPointIndex = canvasPoints.length;
			canvasPoints.push({x: x, y: y});
			refreshCanvasCircle();
		}
	}
	// Right mouse button: Delete point
	else if (ev.button == 2) {
		if (nearest.dist <= POINT_RADIUS + 2) {
			canvasPoints.splice(nearest.index, 1);
			refreshCanvasCircle();
		}
		suppressContextMenu = nearest.dist <= POINT_RADIUS + 10;
	}
};


canvasElem.onmousemove = function(ev) {
	if (dragPointIndex != -1) {
		canvasPoints[dragPointIndex] = {x: ev.offsetX, y: ev.offsetY};
		refreshCanvasCircle();
	}
};


canvasElem.onmouseup = function(ev) {
	if (dragPointIndex != -1 && ev.button == 0) {
		canvasPoints[dragPointIndex] = {x: ev.offsetX, y: ev.offsetY};
		dragPointIndex = -1;
		refreshCanvasCircle();
	}
};


// Assumed to be invoked after onmousedown.
canvasElem.oncontextmenu = function() {
	var result = !suppressContextMenu;
	suppressContextMenu = false;
	return result;
};


canvasElem.onselectstart = function() {  // For Google Chrome
	return false;
};


function doClear() {
	canvasPoints = [];
	refreshCanvasCircle();
}


function doRandom() {
	var scale = Math.min(canvasElem.width, canvasElem.height);
	canvasPoints = [];
	var len = Math.floor((1 - Math.sqrt(Math.random())) * 20) + 2;  // 2 to 20, preferring smaller numbers
	for (var i = 0; i < len; i++) {
		var r = randomGaussianPair();
		canvasPoints.push({
			x: r[0] * scale * 0.15 + canvasElem.width  / 2,
			y: r[1] * scale * 0.15 + canvasElem.height / 2});
	}
	refreshCanvasCircle();
}


function refreshCanvasCircle() {
	// Recompute circle
	canvasCircle = makeCircle(canvasPoints);
	
	// Clear
	var ctx = canvasElem.getContext("2d");
	ctx.clearRect(0, 0, canvasElem.width, canvasElem.height);
	
	// Draw circle first
	if (canvasCircle != null) {
		ctx.fillStyle = CIRCLE_COLOR;
		ctx.beginPath();
		ctx.arc(canvasCircle.x, canvasCircle.y, canvasCircle.r + POINT_RADIUS, 0, Math.PI * 2, false);
		ctx.fill();
	}
	
	// Draw points on top
	ctx.fillStyle = POINT_COLOR;
	canvasPoints.forEach(function(point) {
		ctx.beginPath();
		ctx.arc(point.x, point.y, POINT_RADIUS, 0, Math.PI * 2, false);
		ctx.fill();
	});
}


function findNearestPoint(x, y) {
	var nearestIndex = -1;
	var nearestDist = Infinity;
	canvasPoints.forEach(function(point, i) {
		var d = distance(point.x, point.y, x, y);
		if (d < nearestDist) {
			nearestIndex = i;
			nearestDist = d;
		}
	});
	return {dist: nearestDist, index: nearestIndex};
}


function randomGaussianPair() {
	// Use rejection sampling to pick a point uniformly distributed in the unit circle
	var x, y, magsqr;
	do {
		x = Math.random() * 2 - 1;
		y = Math.random() * 2 - 1;
		magsqr = x * x + y * y;
	} while (magsqr >= 1 || magsqr == 0);
	// Box-Muller transform
	var temp = Math.sqrt(-2 * Math.log(magsqr) / magsqr);
	return [x * temp, y * temp];
}