

class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visit = new HashSet<>();
    private Set<Integer> cycle = new HashSet<>();
    private List<Integer> result = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }

        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs)) {
                return new int[0];
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private boolean dfs(int crs) {

        if (cycle.contains(crs)) return false;

        if (visit.contains(crs)) return true;

        cycle.add(crs);

        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        cycle.remove(crs);
        visit.add(crs);
        result.add(crs);

        return true;
    }
}
