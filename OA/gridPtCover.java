package localrepo.OA;

import java.util.List;

//given some array of points,cover and parse all the points with the least steps
//i/p:pt[]={(1,1),(2,2),(2,3)}
//o/p: 2

public class gridPtCover {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int minSteps(List pts) {
        int numPoints = pts.size();
        if (numPoints <= 1) {
            return 0;
        }
        int totalSteps = 0;
        for (int i = 1; i < numPoints; i++) {
            int xDiff = Math.abs(pts.get(i).x - pts.get(i - 1).x);
        }
    }
}
