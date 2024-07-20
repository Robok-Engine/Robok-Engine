precision mediump float;

varying highp vec2 v_TexCoordinate;
const highp vec2 center = vec2(0.5, 0.5);
const highp float radius = 0.5;

void main() {
	highp float distanceFromCenter = distance(center, v_TexCoordinate);
    lowp float checkForPresenceWithinCircle = step(distanceFromCenter, radius);
//	gl_FragColor = vec4(0.5,0,0,1);
	if (checkForPresenceWithinCircle)
		gl_FragColor = vec4(1.0, 1.0, 0.0, 1.0) * checkForPresenceWithinCircle;     
	else 
		gl_FragColor = vec4(0.0, 0.0, 0.0, 1.0);
}