package com.example.volumecalc.util;

public class CalculateResult {
    public static final int cone = 0;
    public static final int cylinder = 1;

    private int option;
    private Double radius;
    private Double height;
    private float index;

    public CalculateResult(int option, Double radius, Double height) {
        this.option = option;
        this.radius = radius;
        this.height = height;
        this.index = calculate();
    }

    public float getIndex(){
        return index;
    }

    private float calculate() {
        switch (option){
            case cone:
                return (float) (0.33 * 3.14 * radius * radius * height);
            case cylinder:
                return (float) (3.14 * radius * radius * height);
                default:return 0f;
        }
    }
}
