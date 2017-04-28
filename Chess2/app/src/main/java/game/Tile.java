package game;

import android.widget.ImageButton;

import pieces.Piece;
/**
 * Class to represent a tile of the chess board in a game of chess
 * @author Tim Reemmert
 *
 */
public abstract class Tile {
    /**
     * the string representing the location of the tile on the board.
     * For example "a1" is the left most corner of the board
     */
    protected final String coordinate;
    /**
     * Initializes a tile to have the given coordinate
     * @param coordinate
     */
    protected ImageButton image;

    public Tile(String coordinate){
        this.coordinate = coordinate;
    }

    public Tile(String coordinate,ImageButton image){
        this.coordinate = coordinate;
        this.image = image;
    }
    /**
     * Abstract method to return true if a piece is on the tile
     * or false if a piece is not on the tile
     * @return return true is the tile has no piece on it and false if it does
     */
    public abstract boolean isEmpty();
    /**
     * Abstract Method to return the piece currently on the tile.
     * Returns null if there is no piece on the tile.
     * @return Returns the piece on the tile
     */
    public abstract Piece getPiece();
    /**
     * Class to represent a Tile without a piece on it
     * @author Tim Remmert
     *
     */
    public abstract void setImage(ImageButton image);

    public static final class EmptyTile extends Tile {
        /**
         * Initializes the tile to have the given coordinate
         *
         * @param coordinate
         */
        public EmptyTile(String coordinate) {
            super(coordinate);
        }

        public EmptyTile(String coordinate, ImageButton image) {
            super(coordinate, image);
        }

        /**
         * Always returns true because it is an empty tile.
         */
        @Override
        public boolean isEmpty() {
            return true;
        }

        /**
         * Always return null because it is an empty tile.
         */
        @Override
        public Piece getPiece() {
            return null;
        }

        @Override
        public void setImage(ImageButton image) {
            this.image = image;
        }
    }
    /**
     * Class to represent a tile with a piece on it
     * @author Tim Remmert
     *
     */
    public static final class OccupiedTile extends Tile{
        /**
         * The piece currently on the tile
         */
        private Piece piece;
        /**
         * Initializes a tile to have the given coordinate and
         * piece on it.
         * @param coordinate
         * @param piece
         */
        public OccupiedTile(String coordinate, Piece piece){
            super(coordinate);
            this.piece = piece;
        }
        public OccupiedTile(String coordinate, Piece piece, ImageButton image){
            super(coordinate, image);
            this.piece = piece;
        }
        /**
         * Always returns false because there is a piece on the tile
         */
        @Override
        public boolean isEmpty(){
            return false;
        }
        /**
         * return the piece currently on the tile
         */
        @Override
        public Piece getPiece(){
            return this.piece;
        }

        @Override
        public void setImage(ImageButton image){
            this.image = image;
        }
    }

}
