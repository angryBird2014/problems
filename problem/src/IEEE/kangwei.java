package IEEE;

public class kangwei {

    //死亡单位
    final int DEAD = 0;
    //存活单位
    final int ALIVE = 1;

    //变化情况：死亡→死亡
    final int DEAD_TO_DEAD = 0;
    //变化情况：存活→存活
    final int ALIVE_TO_ALIVE = 1;
    //变化情况：存活→死亡
    final int ALIVE_TO_DEAD = 2;
    //变化情况：死亡→存活
    final int DEAD_TO_ALIVE = 3;

    /**
     * 判断某点在本轮变化前是否是死亡状态
     * @param obj
     * @return
     */
    private boolean isAliveOld(int obj) {
        if (obj == ALIVE_TO_ALIVE || obj == ALIVE_TO_DEAD) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 判断某点在本轮变化后是否是死亡状态
     * @param obj
     * @return
     */
    private boolean isAliveNew(int obj) {
        if (obj % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 生命游戏
     * @param board
     */
    public void gameOfLife(int[][] board) {


        int height = board.length;

        int width = board[0].length;

        //考察所有的点，变化其生命状态
        int counter = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                //统计周边生命生存情况
                counter = 0;
                if (i > 0 && j > 0 && isAliveOld(board[i - 1][j - 1])) {
                    counter++;
                }
                if (i > 0 && isAliveOld(board[i - 1][j])) {
                    counter++;
                }
                if (i > 0 && j < width - 1 && isAliveOld(board[i - 1][j + 1])) {
                    counter++;
                }
                if (j > 0 && isAliveOld(board[i][j - 1])) {
                    counter++;
                }
                if (j < width - 1 && isAliveOld(board[i][j + 1])) {
                    counter++;
                }
                if (i < height - 1 && j > 0 && isAliveOld(board[i + 1][j - 1])) {
                    counter++;
                }
                if (i < height - 1 && isAliveOld(board[i + 1][j])) {
                    counter++;
                }
                if (i < height - 1 && j < width - 1 && isAliveOld(board[i + 1][j + 1])) {
                    counter++;
                }

                //根据指定点周边的生命生存情况决定当前点的变化
                if (isAliveOld(board[i][j])) {
                    if (counter < 2) {
                        //1.存活单位周边的存活单位少于2个，该单位死亡
                        board[i][j] = ALIVE_TO_DEAD;
                    } else if (counter == 2 || counter == 3) {
                        //2.存活单位周边的存活单位有2-3个，该单位继续存活
                        board[i][j] = ALIVE_TO_ALIVE;
                    } else {
                        //3.存活单位周边的存活单位多余3个，该单位死亡
                        board[i][j] = ALIVE_TO_DEAD;
                    }
                } else {
                    if (counter == 3) {
                        //4.死亡单位周边的存活单位恰好为3个，该单位变为存活状态
                        board[i][j] = DEAD_TO_ALIVE;
                    } else {
                        board[i][j] = DEAD_TO_DEAD;
                    }
                }
            }
        }

        //根据变换后的存活状态，重新赋予每个点的生死情况
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isAliveNew(board[i][j])) {
                    board[i][j] = ALIVE;
                } else {
                    board[i][j] = DEAD;
                }
            }
        }
    }
}