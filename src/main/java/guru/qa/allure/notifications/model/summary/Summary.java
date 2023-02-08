package guru.qa.allure.notifications.model.summary;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.HashMap;

/**
 * @author kadehar
 * @since 1.0
 * Model class, representing test summary from Allure Report.
 */
@Data
public class Summary {
    @SerializedName("statistic")
    private Statistic statistic;
    @SerializedName("time")
    private Time time;

    public static Summary getInstance(HashMap<String, Integer> statistic) {
        Summary summary = new Summary();
        Statistic stat = new Statistic();
        stat.setTotal(statistic.containsKey("total")?statistic.get("total"):0);
        stat.setFailed(statistic.containsKey("failed")?statistic.get("failed"):0);
        stat.setBroken(statistic.containsKey("broken")?statistic.get("broken"):0);
        stat.setPassed(statistic.containsKey("passed")?statistic.get("passed"):0);
        stat.setSkipped(statistic.containsKey("skipped")?statistic.get("skipped"):0);
        stat.setUnknown(statistic.containsKey("unknown")?statistic.get("unknown"):0);
        summary.setStatistic(stat);
        return summary;
    }
}
