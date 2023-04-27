public class History {
    private static History instance;
    private List<String> urls;

    private History() {
        urls = new ArrayList<>();
    }

    public static synchronized History getInstance() {
        if (instance == null) {
            instance = new History();
        }
        return instance;
    }

    public void addUrl(String url) {
        urls.add(url);
    }

    public List<String> getUrls() {
        return urls;
    }
}


public class Browser {
    private History history;

    public Browser() {
        history = History.getInstance();
    }

    public void visitUrl(String url) {
        // Add the visited URL to the shared history
        history.addUrl(url);
        // Display the URL in the current tab
        System.out.println("Visiting " + url);
    }
}

public class Main {
    public static void main(String[] args) {
        Browser tab1 = new Browser();
        Browser tab2 = new Browser();
        Browser tab3 = new Browser();

        tab1.visitUrl("https://www.google.com");
        tab2.visitUrl("https://www.amazon.com");
        tab3.visitUrl("https://www.facebook.com");

        // All tabs share the same history instance, which should contain all visited URLs
        History history = History.getInstance();
        List<String> urls = history.getUrls();
        System.out.println("Visited URLs:");
        for (String url : urls) {
            System.out.println(url);
        }
    }
}
