package actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import license.CheckLicense;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MakeCoffeeAction extends AnAction {
    private static final String TITLE = "JB Marketplace Demo";
    public MakeCoffeeAction() {
        super();
    }

    public void actionPerformed(@NotNull AnActionEvent event) {
        final boolean isLicensed = CheckLicense.isLicensed();
        Frame frame = JOptionPane.getRootFrame();
        Object[] cities = {"Prague",
                "St. Petersburg",
                "Munich",
                "Moscow",
                "Novosibirsk",
                "Amsterdam",
                "Boston, MA",
                "Marlton, NJ",
                "Foster City, CA"};
        String city = (String)JOptionPane.showInputDialog(
                frame,
                "Please choose the city of your office:",
                "City",
                JOptionPane.PLAIN_MESSAGE,
                null,
                cities,
                "St. Petersburg");

        if ((city != null) && (city.length() > 0)) {
            Object[] coffeeTypes = {"Espresso",
                    "Double Espresso",
                    "Cappuccino",
                    "Flat White",
                    "Caffè Americano",
                    "Caffè Latte",
                    "Long Black",
                    "Macchiato",
                    "Caffè mocha",
                    "Decaf Coffee",
                    "Hot Chocolate",
                    "Kakao",
                    "Tea"};
            String coffeeType = (String) JOptionPane.showInputDialog(
                    frame,
                    "What kind of coffee would you prefer?",
                    "Coffee",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    coffeeTypes,
                    "Espresso");
            if ((coffeeType != null) && (coffeeType.length() > 0)) {
                if (isLicensed) {
                    final String message = "The " + coffeeType + " is being prepared in JetBrains " + city + " office.\n" +
                            "Thank you and welcome to the JetBrains Marketplace!";
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message, TITLE, JOptionPane.INFORMATION_MESSAGE);
                } else {
                    final String message = "Unfortunately, you have not obtain the license yet. We cannot prepare coffee for you.\n" +
                            "Thank you and welcome to the JetBrains Marketplace!";
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message, TITLE, JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
}
