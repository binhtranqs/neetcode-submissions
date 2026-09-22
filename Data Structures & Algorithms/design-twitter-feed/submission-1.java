
class Twitter {
    // Mỗi user có danh sách những người họ theo dõi
    private Map<Integer, Set<Integer>> following;

    // Mỗi user có danh sách tweet của riêng mình
    private Map<Integer, List<Tweet>> tweets;

    private int time;

    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, id -> new ArrayList<>())
              .add(new Tweet(tweetId, time++));
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        following.computeIfAbsent(followerId, id -> new HashSet<>())
                 .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        // Heap đưa tweet mới nhất lên đầu.
        // int[] gồm: {userId, vị trí tweet trong danh sách, thời gian}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])
        );

        // Luôn thêm tweet của chính mình
        addLatestTweet(userId, maxHeap);

        // Thêm tweet mới nhất của từng người đang theo dõi
        for (int followeeId :
                following.getOrDefault(userId, Collections.emptySet())) {
            addLatestTweet(followeeId, maxHeap);
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {
            int[] current = maxHeap.poll();
            int authorId = current[0];
            int index = current[1];

            result.add(tweets.get(authorId).get(index).id);

            // Sau khi lấy tweet này, xét tweet cũ hơn của cùng người đăng
            if (index > 0) {
                int previousIndex = index - 1;
                Tweet previous = tweets.get(authorId).get(previousIndex);
                maxHeap.offer(
                    new int[]{authorId, previousIndex, previous.time}
                );
            }
        }

        return result;
    }

    private void addLatestTweet(int userId, PriorityQueue<int[]> maxHeap) {
        List<Tweet> userTweets = tweets.get(userId);

        if (userTweets == null || userTweets.isEmpty()) return;

        int lastIndex = userTweets.size() - 1;
        Tweet latest = userTweets.get(lastIndex);

        maxHeap.offer(new int[]{userId, lastIndex, latest.time});
    }
}