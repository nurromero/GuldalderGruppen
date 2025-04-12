package com.example.guldaldergruppen.repository

import com.example.guldaldergruppen.model.Shift

class ShiftRepository {
    fun getShifts(): List<Shift> {
        return listOf(
            Shift("07.04.25", "Gadevej 23", "08:00 - 16:00"),
            Shift("08.04.25", "Gadevej 23", "08:00 - 16:00"),
            Shift("09.04.25", "Gadevej 23", "08:00 - 16:00"),
            Shift("12.04.25", "Prinsessegade 11", "08:00 - 16:00")
        )
    }
}
