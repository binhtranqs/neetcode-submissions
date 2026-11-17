
class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visitSet = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Map each course to its prerequisite list
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int crs = pair[0];
            int pre = pair[1];

            preMap.get(crs).add(pre);
        }

        // DFS
        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int crs) {

        if (visitSet.contains(crs)) {
            return false;
        }

        if (preMap.get(crs).isEmpty()) {
            return true;
        }

        visitSet.add(crs);

        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visitSet.remove(crs);

        preMap.put(crs, new ArrayList<>());

        return true;
    }
}