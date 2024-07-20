uniform mat4 u_MVPMatrix;
uniform float u_Thickness;

attribute vec4 a_Position;
attribute vec4 a_TexCoordinate;

varying vec2 v_TexCoordinate;

void main() {
    gl_Position = u_MVPMatrix * a_Position;
	gl_PointSize = u_Thickness;
	v_TexCoordinate = a_TexCoordinate.xy;
}
