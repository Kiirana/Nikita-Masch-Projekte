from WordSearch import WordSearch




if __name__ == '__main__':
    board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
    word = "ABCCED"
    WordObj = WordSearch()
    print(WordObj.maze(board,word))




class WordSearch:
    def __init__(self):
        self.boardMaze = [[]]
        self.boardMap = {}
        self.realPath = []
        self.path = []
        self.tracker = 0

    def maze(self, board, word):

        nothing = "No path found"
        y = 0
        x = 0

        val = 0
        finder = set()

        for i in range(len(board)):
            for j in range(len(board[i])):
                self.boardMap[i, j] = board[i][j]

        if self.solver(board, word, self.path, y, x, self.tracker, val,finder):
                return self.realPath
        else:
            return nothing

    def solver(self, board, word, path, y, x, tracker , val, finder):
        if tracker == len(word):
            self.realPath = path.copy()
            return True

        if (y < len(board) - 1) :
            if (board[y ][x] == word[tracker] and not ((y,x) in finder) ) :
                self.path.append((y , x))
                finder.add((y,x))
                if self.solver(board, word, path, y , x, tracker + 1 , val, finder):
                   return True
                if (len(path) != 0):
                    path.pop()




        if (y < len(board) - 1 and board[y + 1][x] == word[tracker] and not ((y +1,x) in finder)):
            self.path.append((y + 1, x))
            finder.add((y +1, x))
            if self.solver(board, word, path, y + 1, x, tracker + 1 , val, finder):
                return True

            if (len(path) != 0):
                path.pop()


        elif (y > 0 and board[y - 1][x] == word[tracker] and not ((y -1,x)in finder)):
            self.path.append((y - 1, x))
            finder.add((y -1, x))
            if self.solver(board, word, path, y - 1, x, tracker + 1 , val, finder):
                return True
            if (len(path) != 0):
                path.pop()

        elif (x < len(board[y]) - 1 and board[y][x + 1] == word[tracker] and not ((y,x +1) in finder)):
            self.path.append((y, x + 1))
            finder.add((y, x +1))
            if self.solver(board, word, path, y, x + 1, tracker + 1 , val ,finder):
                return True
            if (len(path) != 0):
                path.pop()

        elif (x > 0 and board[y][x - 1] == word[tracker] and not ((y,x -1) in finder)):
            self.path.append((y, x - 1))
            finder.add((y, x -1))
            if self.solver(board, word, path, y, x - 1, tracker + 1 , val,finder):
                return True
            if (len(path) != 0):
                path.pop()




        elif (y <= len(board) -1  and val == 0 and x < len (board[y]) -1 ):




            if (len(path) != 0):
                path.clear()


            if( y == len(board) -1):
               if( self.solver( board, word, path, y , x +1 , tracker % 1 ,val +1,finder )):
                   return  True

            elif(  self.solver(board, word, path, y +1, x , tracker % 1 ,val  ,finder)):
                return True



        elif (y <= len(board) - 1 and val == 1 and y >= 0 and x < len (board[y]) -1):

            if (len(path) != 0):
                path.clear()


            if (y == 0):
                if (self.solver(board, word, path, y , x + 1, tracker % 1, val -1 ,finder)):
                    return True

            elif self.solver(board, word, path, y -1, x, tracker % 1, val ,finder):
                return True






        else:
            return False

        return False
