#include <GL/glut.h>
#include <stdio.h>

void display()
{
    glClear(GL_COLOR_BUFFER_BIT);

    // Set the color to white
    glColor3f(1.0, 1.0, 1.0);

    // Draw a line from (0.1, 0.1) to (0.9, 0.9)
    glBegin(GL_LINES);
    glVertex2f(0.1f, 0.1f);
    glVertex2f(0.9f, 0.9f);
    glEnd();

    glFlush(); // Render now
}

void init()
{
    glClearColor(0.0, 0.0, 0.0, 1.0); // Set background color to black
    glColor3f(1.0, 1.0, 1.0);         // Set line color to white
    glMatrixMode(GL_PROJECTION);
    gluOrtho2D(0.0, 1.0, 0.0, 1.0); // Set the coordinate system
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("OpenGL Line Drawing");

    init();
    glutDisplayFunc(display);
    glutMainLoop(); // Start the event loop
    return 0;
}
