package game;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named(value = "gameBean")
@SessionScoped
public class GameBean implements Serializable {
}
