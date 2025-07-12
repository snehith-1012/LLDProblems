package com.LLD.LLD.ATM;

import com.LLD.LLD.ATM.ATMState.ATMState;
import com.LLD.LLD.VendingMachine.Note;

import java.util.Map;

public class ATM {

    private Map<NoteTypeEnum, Integer> notes;

    private ATMState state;

    private Card card;

    private ATM(Map<NoteTypeEnum, Integer> notes, ATMState state, Card card) {
        this.notes = notes;
        this.state = state;
        this.card = card;
    }

    public static ATM atm = null;

    public static ATM getInstance(Map<NoteTypeEnum, Integer> notes, ATMState state, Card card) {

        if (atm == null) {
            return atm = new ATM(notes, state, card);
        }
        return atm;
    }


    public Map<NoteTypeEnum, Integer> getNotes() {
        return notes;
    }

    public void setNotes(Map<NoteTypeEnum, Integer> notes) {
        this.notes = notes;
    }

    public void addMoney(NoteTypeEnum noteType, int quantity) {
        if (notes.containsKey(noteType)) {
            notes.put(noteType, notes.get(noteType) + quantity);
        } else {
            notes.put(noteType, quantity);
        }
    }

    public void removeMoney(NoteTypeEnum noteTypeEnum, int quantity) {
        if (notes.containsKey(noteTypeEnum) && notes.get(noteTypeEnum) >= quantity) {
            notes.put(noteTypeEnum, notes.get(noteTypeEnum) - quantity);
        }
    }

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
