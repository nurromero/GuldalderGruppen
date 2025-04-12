package com.example.guldaldergruppen.viewmodel

import com.example.guldaldergruppen.repository.ContactRepository
import androidx.lifecycle.ViewModel
import com.example.guldaldergruppen.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.guldaldergruppen.model.Shift
import com.example.guldaldergruppen.repository.ShiftRepository


class MainViewModel : ViewModel() {

    private val contactRepo = ContactRepository()

    private val _contacts = MutableStateFlow(contactRepo.getContacts())
    val contacts: StateFlow<List<Contact>> = _contacts


    private val shiftRepo = ShiftRepository()
    private val _shifts = MutableStateFlow(shiftRepo.getShifts())
    val shifts: StateFlow<List<Shift>> = _shifts


}
