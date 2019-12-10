package com.mesaj.example.model.registereduser

import groovy.transform.ToString

@ToString
class RegisteredUser {

    Integer page
    Integer perPage
    Integer total
    Integer totalPages
    List<Datum> data = null
}
