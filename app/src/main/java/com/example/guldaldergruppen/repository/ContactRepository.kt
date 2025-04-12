package com.example.guldaldergruppen.repository


import com.example.guldaldergruppen.model.Contact


class ContactRepository {
    fun getContacts(): List<Contact> {
        return listOf(
            Contact("Guldaldergruppen", "+45 23 23 25 25"),
            Contact("Nedriver 1", "+45 32 24 25 57"),
            Contact("Nedriver 1", "+45 56 23 21 92"),
            Contact("Nedriver 1", "+45 22 66 95 25"),
        )
    }
}
