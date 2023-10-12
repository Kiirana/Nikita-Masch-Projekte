 from Maze import Maze

if __name__ == '__main__':
    T = [
        [5, 5],
        [1, 0, 1, 1, 1],
        [1, 0, 0, 0, 1],
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 1],
        [1, 1, 1, 1, 1],
    ]
    obj = Maze()

    obj.mazeSolver(T)



class Maze:
    def __init__(self):
        self.dictPath = {}
        self.matrixList = [[]]
        self.realPath = []

    def mazeSolver(self, maze):
        pathLine = []
        self.matrixList = maze
        for y in range(1, maze[0][0] +1):
            for x in range(maze[0][1]):
                self.dictPath[y, x] = maze[y][x]

        x = 0
        y = 0

        if self.path(maze, x, y, pathLine):
            print("Path found:", self.realPath)
        else:
            print("No path found")

    def check(self, y, x):
        if self.dictPath.get((y, x)) == 1:

            return True
        else:
            return False

    def path(self, maze, x, y, pathLine):
        if y == maze[0][0] - 1 and x == maze[0][1] - 1:


            self.realPath = pathLine.copy()

            return True
        else:
            if y < maze[0][0] - 1 and maze[y + 1][x] == 1:

                pathLine.append((y + 1, x))
                if self.path(maze, x, y + 1, pathLine):
                    return True
                pathLine.pop()

            if x < maze[0][1] - 1 and maze[y][x + 1] == 1:
                pathLine.append((y, x + 1))
                if self.path(maze, x + 1, y, pathLine):
                    return True
                pathLine.pop()

            return False
