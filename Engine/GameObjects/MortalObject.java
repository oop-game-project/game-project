package Engine.GameObjects;

public abstract class MortalObject extends MovableObject implements Cloneable
{
    private int hitPoints = this.getHitPointsMax();

    public MortalObject(int[] inputLocation)
    {
        super(inputLocation);
    }

    public abstract int getHitPointsMax();

    public boolean isDead()
    {
        return hitPoints == 0;
    }

    private void addToHitPoints(int addendum)
    {
        this.hitPoints += addendum;

        if (this.hitPoints < 0)
            this.hitPoints = 0;
    }

    public void receiveDamageFromBasicProjectile()
    {
        this.addToHitPoints(-1);
    }

    public void receiveDamageFromCollisionWithMob()
    {
        this.addToHitPoints(-1);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
