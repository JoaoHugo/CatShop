package djc.catshop.output;

public class FeeOutputDto {

    private Double totalFee;

    public FeeOutputDto(Double totalFee) {
        this.totalFee = totalFee;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }
}
