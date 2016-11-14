package rich.Place;

import rich.Player;

public class Estate implements Place {
    private Player owner;
    private double price;
    private Level level;

    public Estate(double price) {
        this.owner = null;
        this.price = price;
        level = Level.ZERO;
    }

    public static Estate createEstateWithOwner(double price, Player owner){
        Estate estate = new Estate(price);
        estate.owner = owner;
        return estate;
    }

    public boolean buy(Player player){
        if(owner == null) {
            owner = player;
            return true;
        }
        return false;
    }

    public Player getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    public Level getLevel() {
        return level;
    }

    public boolean promote() {
        if(level.ordinal() < Level.TOP.ordinal()) {
            level = level.next();
            return true;
        }
        return false;
    }

    public enum Level {
        ZERO {
            @Override
            public Level next() {
                return ONE;
            }
        },
        ONE {
            @Override
            public Level next() {
                return TOP;
            }
        },
        TWO {
            @Override
            public Level next() {
                return TOP;
            }
        },
        TOP {
            @Override
            public Level next() {
                return TOP;
            }
        };

        public abstract Level next();
    }
}