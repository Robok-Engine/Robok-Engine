package org.gampiot.robok.feature.modeling.objects

/*
* Command to create object on ModelingScreen.
* see {@link ObjectsCreator} for see that methods.
* see {@link Model3DView} for see that methods call.
* @author Aquiles Trindade (trindadedev).
*/
object ObjectCommand {
    const val CREATE_CUBE = "createCube"
    const val CREATE_TRIANGLE = "createTriangle"
    const val CREATE_SPHERE = "createSphere"
    const val CREATE_CYLINDER = "createCylinder"
    const val CREATE_CONE = "createCone"
    const val CREATE_PLANE = "createPlane"
    const val CREATE_TRIANGLE_2D = "createTriangle2D"
}