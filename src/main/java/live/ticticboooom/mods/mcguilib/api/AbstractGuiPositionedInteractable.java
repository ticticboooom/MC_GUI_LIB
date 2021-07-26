package live.ticticboooom.mods.mcguilib.api;

import live.ticticboooom.mods.mcguilib.api.base.IGuiInteractable;

public abstract class AbstractGuiPositionedInteractable implements IGuiInteractable {
    protected int x;
    protected int y;
    protected int width;
    protected int height;


    public AbstractGuiPositionedInteractable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected abstract void onClickInBounds(int mouseX, int mouseY);

    @Override
    public void onClick(int mouseX, int mouseY) {
        boolean fitX = mouseX > x && mouseX < x + width;
        boolean fitY = mouseY > y && mouseY < y + height;
        if (fitX && fitY){
            onClickInBounds(mouseX, mouseY);
        }
    }
}
