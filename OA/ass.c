#include <graphics.h>
#include <stdio.h>
#include <math.h>

void DDA(int x1, int y1, int x2, int y2)
{
    int dx = x2 - x1;
    int dy = y2 - y1;
    int steps;
    float xIncrement, yIncrement, x = x1, y = y1;

    // Determine the number of steps needed
    if (abs(dx) > abs(dy))
    {
        steps = abs(dx);
    }
    else
    {
        steps = abs(dy);
    }

    // Calculate the increment in x and y
    xIncrement = dx / (float)steps;
    yIncrement = dy / (float)steps;

    // Draw the line
    for (int i = 0; i <= steps; i++)
    {
        putpixel(round(x), round(y), WHITE); // Plot the pixel
        x += xIncrement;
        y += yIncrement;
    }
}

int main()
{
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");

    int x1, y1, x2, y2;

    // Input coordinates of the line
    printf("Enter the coordinates of the starting point (x1 y1): ");
    scanf("%d %d", &x1, &y1);
    printf("Enter the coordinates of the ending point (x2 y2): ");
    scanf("%d %d", &x2, &y2);

    // Draw the line using DDA algorithm
    DDA(x1, y1, x2, y2);

    getch();      // Wait for a key press
    closegraph(); // Close the graphics window
    return 0;
}
