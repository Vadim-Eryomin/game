package StemFight;

public class ExperienceAndLevels {
    int level = 0;
    int experience = 0;
    int experienceLevel = 100;
    public void update(Game game){
        this.experience = game.hero.xp;
        if (experience >= experienceLevel){
            experience = (game.hero.xp = 0);
            experienceLevel += 100;
            level++;
            if (level % 5 == 0){
                game.sgf.skillPoints++;
                game.spf.skillPoints++;
            }
            game.hero.charsUp++;
        }
        game.charFrame.xp = this.level;
    }

}
