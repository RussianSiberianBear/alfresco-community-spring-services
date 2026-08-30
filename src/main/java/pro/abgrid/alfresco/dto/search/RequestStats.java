package pro.abgrid.alfresco.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * RU: DTO-модель Alfresco REST API: RequestStats.
 * EN: Alfresco REST API DTO model: RequestStats.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestStats {
    /**
     * <p><strong>RU:</strong> значение поля «field» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>
     * <p><strong>EN:</strong> The stats field. Optional unless a specific endpoint requires it.</p>
     */
    private String field;

    /**

     * <p><strong>RU:</strong> значение поля «label» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A label to include for reference the stats field. Optional unless a specific endpoint requires it.</p>

     */

    private String label;

    /**

     * <p><strong>RU:</strong> значение поля «min» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The minimum value of the field. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean min;

    /**

     * <p><strong>RU:</strong> значение поля «max» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The maximum value of the field. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean max;

    /**

     * <p><strong>RU:</strong> значение поля «sum» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The sum of all values of the field. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean sum;

    /**

     * <p><strong>RU:</strong> значение поля «count values» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number which have a value for this field. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean countValues;

    /**

     * <p><strong>RU:</strong> значение поля «missing» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number which do not have a value for this field. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean missing;

    /**

     * <p><strong>RU:</strong> значение поля «mean» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The average. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean mean;

    /**

     * <p><strong>RU:</strong> значение поля «stddev» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Standard deviation. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean stddev;

    /**

     * <p><strong>RU:</strong> значение поля «sum of squares» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Sum of all values squared. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean sumOfSquares;

    /**

     * <p><strong>RU:</strong> значение поля «distinct values» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The set of all distinct values for the field (This can be very expensive to calculate). Optional unless a specific endpoint requires it.</p>

     */

    private Boolean distinctValues;

    /**

     * <p><strong>RU:</strong> значение поля «count distinct» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> The number of distinct values (This can be very expensive to calculate). Optional unless a specific endpoint requires it.</p>

     */

    private Boolean countDistinct;

    /**

     * <p><strong>RU:</strong> значение поля «cardinality» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A statistical approximation of the number of distinct values. Optional unless a specific endpoint requires it.</p>

     */

    private Boolean cardinality;

    /**

     * <p><strong>RU:</strong> значение поля «cardinality accuracy» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> Number between 0.0 and 1.0 indicating how aggressively the algorithm should try to be accurate. Used with boolean cardinality flag.. Optional unless a specific endpoint requires it.</p>

     */

    private Double cardinalityAccuracy;

    /**

     * <p><strong>RU:</strong> значение поля «exclude filters» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A list of filters to exclude. Optional unless a specific endpoint requires it.</p>

     */

    private List<String> excludeFilters;

    /**

     * <p><strong>RU:</strong> значение поля «percentiles» модели Alfresco REST API. Поле опционально, если конкретный endpoint не требует его явно.</p>

     * <p><strong>EN:</strong> A list of percentile values, e.g. "1,99,99.9". Optional unless a specific endpoint requires it.</p>

     */

    private List<Double> percentiles;

    /**
     * RU: Создаёт экземпляр RequestStats.
     * EN: Creates a RequestStats instance.
     */
    public RequestStats() {
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The stats field.</p>
     *
     * @return RU: текущее значение field. EN: current value of field.
     */

    public String getField() {
        return field;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «field» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The stats field.</p>
     *
     * @param field RU: новое значение field. EN: new value for field.
     */

    public void setField(String field) {
        this.field = field;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A label to include for reference the stats field.</p>
     *
     * @return RU: текущее значение label. EN: current value of label.
     */

    public String getLabel() {
        return label;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «label» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A label to include for reference the stats field.</p>
     *
     * @param label RU: новое значение label. EN: new value for label.
     */

    public void setLabel(String label) {
        this.label = label;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «min» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The minimum value of the field.</p>
     *
     * @return RU: текущее значение min. EN: current value of min.
     */

    public Boolean getMin() {
        return min;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «min» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The minimum value of the field.</p>
     *
     * @param min RU: новое значение min. EN: new value for min.
     */

    public void setMin(Boolean min) {
        this.min = min;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «max» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The maximum value of the field.</p>
     *
     * @return RU: текущее значение max. EN: current value of max.
     */

    public Boolean getMax() {
        return max;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «max» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The maximum value of the field.</p>
     *
     * @param max RU: новое значение max. EN: new value for max.
     */

    public void setMax(Boolean max) {
        this.max = max;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «sum» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The sum of all values of the field.</p>
     *
     * @return RU: текущее значение sum. EN: current value of sum.
     */

    public Boolean getSum() {
        return sum;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «sum» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The sum of all values of the field.</p>
     *
     * @param sum RU: новое значение sum. EN: new value for sum.
     */

    public void setSum(Boolean sum) {
        this.sum = sum;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «count values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number which have a value for this field.</p>
     *
     * @return RU: текущее значение countValues. EN: current value of countValues.
     */

    public Boolean getCountValues() {
        return countValues;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «count values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number which have a value for this field.</p>
     *
     * @param countValues RU: новое значение countValues. EN: new value for countValues.
     */

    public void setCountValues(Boolean countValues) {
        this.countValues = countValues;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «missing» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number which do not have a value for this field.</p>
     *
     * @return RU: текущее значение missing. EN: current value of missing.
     */

    public Boolean getMissing() {
        return missing;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «missing» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number which do not have a value for this field.</p>
     *
     * @param missing RU: новое значение missing. EN: new value for missing.
     */

    public void setMissing(Boolean missing) {
        this.missing = missing;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «mean» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The average.</p>
     *
     * @return RU: текущее значение mean. EN: current value of mean.
     */

    public Boolean getMean() {
        return mean;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «mean» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The average.</p>
     *
     * @param mean RU: новое значение mean. EN: new value for mean.
     */

    public void setMean(Boolean mean) {
        this.mean = mean;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «stddev» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Standard deviation.</p>
     *
     * @return RU: текущее значение stddev. EN: current value of stddev.
     */

    public Boolean getStddev() {
        return stddev;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «stddev» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Standard deviation.</p>
     *
     * @param stddev RU: новое значение stddev. EN: new value for stddev.
     */

    public void setStddev(Boolean stddev) {
        this.stddev = stddev;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «sum of squares» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Sum of all values squared.</p>
     *
     * @return RU: текущее значение sumOfSquares. EN: current value of sumOfSquares.
     */

    public Boolean getSumOfSquares() {
        return sumOfSquares;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «sum of squares» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Sum of all values squared.</p>
     *
     * @param sumOfSquares RU: новое значение sumOfSquares. EN: new value for sumOfSquares.
     */

    public void setSumOfSquares(Boolean sumOfSquares) {
        this.sumOfSquares = sumOfSquares;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «distinct values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The set of all distinct values for the field (This can be very expensive to calculate).</p>
     *
     * @return RU: текущее значение distinctValues. EN: current value of distinctValues.
     */

    public Boolean getDistinctValues() {
        return distinctValues;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «distinct values» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The set of all distinct values for the field (This can be very expensive to calculate).</p>
     *
     * @param distinctValues RU: новое значение distinctValues. EN: new value for distinctValues.
     */

    public void setDistinctValues(Boolean distinctValues) {
        this.distinctValues = distinctValues;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «count distinct» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns The number of distinct values (This can be very expensive to calculate).</p>
     *
     * @return RU: текущее значение countDistinct. EN: current value of countDistinct.
     */

    public Boolean getCountDistinct() {
        return countDistinct;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «count distinct» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets The number of distinct values (This can be very expensive to calculate).</p>
     *
     * @param countDistinct RU: новое значение countDistinct. EN: new value for countDistinct.
     */

    public void setCountDistinct(Boolean countDistinct) {
        this.countDistinct = countDistinct;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «cardinality» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A statistical approximation of the number of distinct values.</p>
     *
     * @return RU: текущее значение cardinality. EN: current value of cardinality.
     */

    public Boolean getCardinality() {
        return cardinality;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «cardinality» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A statistical approximation of the number of distinct values.</p>
     *
     * @param cardinality RU: новое значение cardinality. EN: new value for cardinality.
     */

    public void setCardinality(Boolean cardinality) {
        this.cardinality = cardinality;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «cardinality accuracy» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns Number between 0.0 and 1.0 indicating how aggressively the algorithm should try to be accurate. Used with boolean cardinality flag..</p>
     *
     * @return RU: текущее значение cardinalityAccuracy. EN: current value of cardinalityAccuracy.
     */

    public Double getCardinalityAccuracy() {
        return cardinalityAccuracy;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «cardinality accuracy» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets Number between 0.0 and 1.0 indicating how aggressively the algorithm should try to be accurate. Used with boolean cardinality flag..</p>
     *
     * @param cardinalityAccuracy RU: новое значение cardinalityAccuracy. EN: new value for cardinalityAccuracy.
     */

    public void setCardinalityAccuracy(Double cardinalityAccuracy) {
        this.cardinalityAccuracy = cardinalityAccuracy;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A list of filters to exclude.</p>
     *
     * @return RU: текущее значение excludeFilters. EN: current value of excludeFilters.
     */

    public List<String> getExcludeFilters() {
        return excludeFilters;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «exclude filters» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A list of filters to exclude.</p>
     *
     * @param excludeFilters RU: новое значение excludeFilters. EN: new value for excludeFilters.
     */

    public void setExcludeFilters(List<String> excludeFilters) {
        this.excludeFilters = excludeFilters;
    }

        /**
     * <p><strong>RU:</strong> Возвращает значение поля «percentiles» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Returns A list of percentile values, e.g. "1,99,99.9".</p>
     *
     * @return RU: текущее значение percentiles. EN: current value of percentiles.
     */

    public List<Double> getPercentiles() {
        return percentiles;
    }

        /**
     * <p><strong>RU:</strong> Устанавливает значение поля «percentiles» модели Alfresco REST API.</p>
     * <p><strong>EN:</strong> Sets A list of percentile values, e.g. "1,99,99.9".</p>
     *
     * @param percentiles RU: новое значение percentiles. EN: new value for percentiles.
     */

    public void setPercentiles(List<Double> percentiles) {
        this.percentiles = percentiles;
    }

}
