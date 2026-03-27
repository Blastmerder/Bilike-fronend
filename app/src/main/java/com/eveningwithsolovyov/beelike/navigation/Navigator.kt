package com.eveningwithsolovyov.beelike.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Navigator(val backStack: NavBackStack<NavKey>) {

    fun navigate(route: NavKey) {
        backStack.add(route)
    }

    fun navigateIrrevocably(route: NavKey) {
        backStack.add(route)
        backStack.subList(0, backStack.size - 1).clear()
    }

    fun goBack() {
        backStack.removeLastOrNull()
    }
}