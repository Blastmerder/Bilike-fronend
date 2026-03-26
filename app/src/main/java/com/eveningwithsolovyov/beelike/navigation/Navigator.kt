package com.eveningwithsolovyov.beelike.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Navigator(val backStack: NavBackStack<NavKey>) {

    fun navigate(route: NavKey) {
        backStack.add(route)
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }
}