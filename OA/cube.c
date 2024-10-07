#include <GL/glut.h>
// Function to draw a cube
void drawCube()
{
    glBegin(GL_QUADS);
    // Front face (Red)
    glColor3f(1.0, 0.0, 0.0); // Red color
    glVertex3f(-0.5f, -0.5f, 0.5f);
    glVertex3f(0.5f, -0.5f, 0.5f);
    glVertex3f(0.5f, 0.5f, 0.5f);
    glVertex3f(-0.5f, 0.5f, 0.5f);
    // Back face (not colored)
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glVertex3f(-0.5f, -0.5f, -0.5f);
    glVertex3f(-0.5f, 0.5f, -0.5f);
    glVertex3f(0.5f, 0.5f, -0.5f);
    glVertex3f(0.5f, -0.5f, -0.5f);
    // Left face (Blue)
    glColor3f(0.0, 0.0, 1.0); // Blue color
    glVertex3f(-0.5f, -0.5f, -0.5f);
    glVertex3f(-0.5f, -0.5f, 0.5f);
    glVertex3f(-0.5f, 0.5f, 0.5f);
    glVertex3f(-0.5f, 0.5f, -0.5f);
    // Right face (Pink)
    glColor3f(1.0, 0.75, 0.8); // Pink color
    glVertex3f(0.5f, -0.5f, -0.5f);
    glVertex3f(0.5f, 0.5f, -0.5f);
    glVertex3f(0.5f, 0.5f, 0.5f);
    glVertex3f(0.5f, -0.5f, 0.5f);
    // Top face (not colored)
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glVertex3f(-0.5f, 0.5f, -0.5f);
    glVertex3f(-0.5f, 0.5f, 0.5f);
    glVertex3f(0.5f, 0.5f, 0.5f);
    glVertex3f(0.5f, 0.5f, -0.5f);

    // Bottom face (not colored)
    glColor3f(0.5, 0.5, 0.5); // Gray color
    glVertex3f(-0.5f, -0.5f, -0.5f);
    glVertex3f(0.5f, -0.5f, -0.5f);
    glVertex3f(0.5f, -0.5f, 0.5f);
    glVertex3f(-0.5f, -0.5f, 0.5f);
    glEnd();
}
void display()
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    glLoadIdentity();
    glTranslatef(0.0f, 0.0f, -3.0f);    // Move back to see the cube
    glRotatef(45.0f, 1.0f, 1.0f, 0.0f); // Rotate for better view
    drawCube();                         // Draw the cube
    glFlush();
    glutSwapBuffers(); // Swap buffers for smooth rendering
}
// Initialize OpenGL settings
void init()
{
    glEnable(GL_DEPTH_TEST);          // Enable depth testing for proper rendering
    glClearColor(1.0, 1.0, 1.0, 1.0); // White background
    glMatrixMode(GL_PROJECTION);
    gluPerspective(45.0, 1.0, 0.1, 100.0); // Perspective projection
    glMatrixMode(GL_MODELVIEW);
}
int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("Colored Cube");

    init();
    glutDisplayFunc(display);
    glutIdleFunc(display); // Keep redrawing the display
    glutMainLoop();        // Start the event loop
    return 0;
}
