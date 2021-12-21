package Level2;

public class SkillTree {
    public static int solution(String skill, String[] skill_trees) {
        int cnt = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int index = 0;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                int currIndex = skill.indexOf(skill_trees[i].charAt(j));
                if (currIndex >= 0) {
                    if (index != currIndex)
                        break;
                    else
                        index++;
                }
                if (j == skill_trees[i].length() - 1)
                    cnt++;
            }
        }
        return cnt;
    }
}
