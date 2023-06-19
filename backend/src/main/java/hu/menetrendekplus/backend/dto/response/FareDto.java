package hu.menetrendekplus.backend.dto.response;

import java.util.Objects;

public class FareDto {

    private int noDiscount;

    private int fiftyDiscount;

    private int ninetyDiscount;

    public FareDto(int noDiscount, int fiftyDiscount, int ninetyDiscount) {
        this.noDiscount = noDiscount;
        this.fiftyDiscount = fiftyDiscount;
        this.ninetyDiscount = ninetyDiscount;
    }

    public FareDto() {
    }

    public int getNoDiscount() {
        return noDiscount;
    }

    public void setNoDiscount(int noDiscount) {
        this.noDiscount = noDiscount;
    }

    public int getFiftyDiscount() {
        return fiftyDiscount;
    }

    public void setFiftyDiscount(int fiftyDiscount) {
        this.fiftyDiscount = fiftyDiscount;
    }

    public int getNinetyDiscount() {
        return ninetyDiscount;
    }

    public void setNinetyDiscount(int ninetyDiscount) {
        this.ninetyDiscount = ninetyDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FareDto fareDto = (FareDto) o;
        return noDiscount == fareDto.noDiscount && fiftyDiscount == fareDto.fiftyDiscount && ninetyDiscount == fareDto.ninetyDiscount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(noDiscount, fiftyDiscount, ninetyDiscount);
    }

    @Override
    public String toString() {
        return "FareDto{" +
                "noDiscount=" + noDiscount +
                ", fiftyDiscount=" + fiftyDiscount +
                ", ninetyDiscount=" + ninetyDiscount +
                '}';
    }
}
