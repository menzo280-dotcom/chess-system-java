package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != getColor();
    }

    private boolean isThereNoPiece(Position position) {
        return getBoard().piece(position) == null;
    }

    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat =
                new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {

            p.setValues(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && isThereNoPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 =
                    new Position(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p)
                    && isThereNoPiece(p)
                    && getBoard().positionExists(p2)
                    && isThereNoPiece(p2)
                    && getMoveCount() == 0) {

                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1,
                    position.getColumn() - 1);

            if (getBoard().positionExists(p)
                    && isThereOpponentPiece(p)) {

                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1,
                    position.getColumn() + 1);

            if (getBoard().positionExists(p)
                    && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        else {
            p.setValues(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(p) && isThereNoPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(p)
                    && isThereNoPiece(p)
                    && getBoard().positionExists(p2)
                    && isThereNoPiece(p2)
                    && getMoveCount() == 0) {

                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1,
                    position.getColumn() - 1);

            if (getBoard().positionExists(p)
                    && isThereOpponentPiece(p)) {

                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1,
                    position.getColumn() + 1);

            if (getBoard().positionExists(p)
                    && isThereOpponentPiece(p)) {

                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}