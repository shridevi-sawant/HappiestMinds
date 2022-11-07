package com.happiestminds.uidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Timer

class MenuDemoActivity : AppCompatActivity() {

    lateinit var demoPopup : PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_demo)

        val btn1 = findViewById<Button>(R.id.button2)
        registerForContextMenu(btn1)

        setupPopupMenu()

        findViewById<ConstraintLayout>(R.id.layoutC).setOnLongClickListener {
            demoPopup.show()
            true
        }


    }

    private fun setupPopupMenu() {
        val demoButton = findViewById<Button>(R.id.demoB)
        demoPopup = PopupMenu(this, demoButton)

        demoPopup.menu.add("Radio Button")
        demoPopup.menu.add("Check Box")
        demoPopup.menu.add("List View")
        demoPopup.menu.add("Dialog")
        demoPopup.menu.add("Notification")

        demoPopup.setOnMenuItemClickListener {
            when(it.title){
                "Notification" -> {
                    // launch Activity
                    val notificationIntent = Intent(this,
                        NotificationActivity().javaClass)
                    startActivity(notificationIntent)

                }
                else -> {
                    Toast.makeText(this, "SELECTION: ${it.title} ",
                        Toast.LENGTH_LONG).show()
                }
            }

            true
        }
    }

    private val MENU_OPTION1 = 1
    private val MENU_OPTION2 = 2

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu?.add(0, MENU_OPTION1, 0, "Option 1")
        menu?.add(0, MENU_OPTION2, 0, "Option 2")

        val op3 = menu?.addSubMenu("Option 3")
        op3?.add("Connect")
        op3?.add("Disconnect")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            MENU_OPTION1 -> {
                Toast.makeText(this, "Option 1 selected",
                    Toast.LENGTH_LONG).show()
            }
            MENU_OPTION2 -> {
                Toast.makeText(this, "Option 2 selected..",
                    Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }


    private val MENU_SETTINGS = 1
    private val MENU_CANCEL = 2
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // design menu by adding few menuitems
        menu?.add(0, MENU_SETTINGS, 0, "Settings")
        menu?.add(0, MENU_CANCEL, 1, "Cancel")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle selection of menuitem
        when (item.itemId) {
            MENU_SETTINGS -> {
                Toast.makeText(this, "Settings to be displayed..",
                    Toast.LENGTH_LONG).show()
            }
            MENU_CANCEL -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun demoClick(view: View) {
        // show popup menu

        demoPopup.show()
    }
}