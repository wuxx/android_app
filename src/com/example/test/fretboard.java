package com.example.test;

import java.util.Random;

public class fretboard {
    int string_index_max=6;
    int string_index_min=1;
    int string_index = 1;	/* [1, 6] */
    String[] string_name = new String[]{"零", "一","二","三","四","五","六"};
    String[] tone_name = new String[]{"C", "C#/Db", "D", "D#/Eb", "E", "F", "F#/Gb", "G", "G#/Ab", "A", "A#/Bb", "B"}; 
    int tone_base[] = {-1, 4+12+12, 11+12, 7+12, 2+12, 9, 4}; /* NA E3 B2 G2 D2 A1 E1 */
    int fret_index_max=11;
    int fret_index_min=0;
    int fret_index = 0;	/* [0, 11] */
    int tone = 0;		/* [4, 40] */
    Random random = new Random();
    public void update() {
        this.string_index = this.random.nextInt((this.string_index_max-this.string_index_min+1)) + this.string_index_min;
        this.fret_index = this.random.nextInt((this.fret_index_max-this.fret_index_min)+1) + this.fret_index_min;
        this.tone = (this.tone_base[this.string_index]+this.fret_index);
    }
}
