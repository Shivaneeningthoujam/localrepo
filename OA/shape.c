#include <GL/glut.h>
#include <math.h>

// Function to draw a black line
void drawLine()
{
    glBegin(GL_LINES);
    glColor3f(0.0, 0.0, 0.0); // Black color
    glVertex2f(-0.5f, 0.0f);  // Start point
    glVertex2f(0.5f, 0.0f);   // End point
    glEnd();
}

// Function to draw an outlined black circle
void drawCircle(float radius, int num_segments)
{
    glBegin(GL_LINE_LOOP);
    glColor3f(0.0, 0.0, 0.0); // Black color
    for (int i = 0; i < num_segments; i++)
    {
        float angle = 2.0f * M_PI * i / num_segments; // Angle for each segment
        float x = radius * cos(angle);                // X coordinate
        float y = radius * sin(angle);                // Y coordinate
        glVertex2f(x, y);
    }
    glEnd();
}

// Function to draw a filled black triangle
void drawTriangle()
{
    glBegin(GL_TRIANGLES);
    glColor3f(0.0, 0.0, 0.0); // Black color
    glVertex2f(-0.5f, -0.5f); // Bottom left
    glVertex2f(0.5f, -0.5f);  // Bottom right
    glVertex2f(0.0f, 0.5f);   // Top
    glEnd();
}

// Function to draw a filled black square
void drawSquare()
{
    glBegin(GL_QUADS);
    glColor3f(0.0, 0.0, 0.0); // Black color
    glVertex2f(-0.3f, -0.3f); // Bottom left
    glVertex2f(0.3f, -0.3f);  // Bottom right
    glVertex2f(0.3f, 0.3f);   // Top right
    glVertex2f(-0.3f, 0.3f);  // Top left
    glEnd();
}

// Display function
void display()
{
    glClear(GL_COLOR_BUFFER_BIT);

    drawLine();            // Draw a black line
    drawCircle(0.5f, 100); // Draw an outlined circle
    drawTriangle();        // Draw a filled black triangle
    drawSquare();          // Draw a filled black square

    glFlush(); // Render now
}

// Initialize OpenGL settings
void init()
{
    glClearColor(1.0, 1.0, 1.0, 1.0); // White background
    glMatrixMode(GL_PROJECTION);
    gluOrtho2D(-1.0, 1.0, -1.0, 1.0); // Set coordinate system
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_SINGLE);
    glutInitWindowSize(500, 500);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("Basic Geometric Shapes in OpenGL");

    init();
    glutDisplayFunc(display);
    glutMainLoop(); // Start the event loop
    return 0;
}
