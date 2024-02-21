package ladder.view;

import ladder.domain.StepStatus;
import ladder.dto.LadderResult;
import ladder.dto.LineResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static void printLadderResult(LadderResult ladderResult) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(makeNameMessage(ladderResult.names()));
        System.out.println(drawRadder(ladderResult.lines()));
    }

    private static String makeNameMessage(List<String> userNames) {
        int middle = userNames.size() / 2;
        String s1 = makeName(0, middle, "%5s", userNames);
        String s2 = makeName(middle, userNames.size(), "%-5s", userNames);
        return String.join(" ", s1, s2);
    }

    private static String formatName(String type, String name) {
        return String.format(type, name);
    }

    private static String makeName(int start, int end, String type, List<String> userNames) {
        return IntStream.range(start, end)
                .mapToObj(i -> formatName(type, userNames.get(i)))
                .collect(Collectors.joining(" "));
    }

    private static String drawRadder(List<LineResult> lineResults) {
        return lineResults.stream()
                .map(OutputView::drawLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private static String drawLine(LineResult lineResult) {
        String prefix = "    |";
        String steps = lineResult.value()
                .stream()
                .map(OutputView::drawStep)
                .collect(Collectors.joining());
        return prefix + steps;
    }

    private static String drawStep(StepStatus stepStatus) {
        if (stepStatus.isExist()) {
            return "-----|";
        }
        return "     |";
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
