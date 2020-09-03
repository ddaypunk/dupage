package com.ddaypunk.dupage.components;

import com.ddaypunk.dupage.core.Selector;

public class Button extends Component {
    private static final Selector selector = new Selector("data-test-button");
    public Button(String name) {
        super(new Selector(selector.getAttribute(), name));
    }

    public Button(Selector selector, boolean isVisibilityRequired) {
        super(selector, isVisibilityRequired);
    }

    @Override
    public void click(){
        getRoot().click();
    }
}
