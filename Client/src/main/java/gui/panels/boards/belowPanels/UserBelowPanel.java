package gui.panels.boards.belowPanels;

import models.GameState;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;


public class UserBelowPanel {
    @Autowired
    private BelowPanelsFactory belowPanelsFactory;

    private JPanel userBelowPanel = new JPanel();

    private CardLayout belowCardLayout = new CardLayout();


    public JPanel getUserBelowPanel() {
        userBelowPanel.setLayout(belowCardLayout);
        userBelowPanel.add(belowPanelsFactory.getBelowPanel(GameState.YouArePlaying), GameState.YouArePlaying.toString());
        userBelowPanel.add(belowPanelsFactory.getBelowPanel(GameState.YouCanPlay), GameState.YouCanPlay.toString());
        userBelowPanel.add(belowPanelsFactory.getBelowPanel(GameState.NotYourTurn), GameState.NotYourTurn.toString());
        return userBelowPanel;
    }

    public void showBelowPanel(GameState gameState) {
        belowCardLayout.show(userBelowPanel, gameState.toString());
    }
}
