package com.example.runninglist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.runninglist.Retrofits.ApiInterface
import com.example.runninglist.Retrofits.UserTaskItem


import com.example.runninglist.databinding.ActivityMain2Binding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity(),AboutTaskAdapter.Listener {

    private val BigRandom: Int
        get() = Random().nextInt(100000)
    lateinit var task2: AboutTask
    lateinit var currentDate: Date
    lateinit var dateFormate: SimpleDateFormat
    lateinit var binding: ActivityMain2Binding
    private var AddTaskLauncher: ActivityResultLauncher<Intent>? = null
    private val adapter = AboutTaskAdapter(this)

    final var ID_MOVE_R = 1
    final var ID_MOVE_L = 2
    final var ID_CHANGE = 4
    final var ID_REMOVE = 3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        AddTaskLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                if (it.resultCode == RESULT_OK) {
                    var task = it.data!!.getSerializableExtra("task") as DataClassTaskUsers;
                    var OsnTask = AboutTask(
                        BigRandom,
                        task.NameTask,
                        task.ImageTask1,
                        task.ImageTask2,
                        task.ImageTask3,
                        task.ImageTask4,
                        task.ImageTask5,
                        task.ImageTask6,
                        task.ImageTask7,
                        task.Day,
                        task.Description
                    );
                    adapter.appLant(OsnTask)
                    adapter.Sets()
                    insertTask(OsnTask)
                }


            }

        binding.apply {
            TaskList.layoutManager = LinearLayoutManager(this@MainActivity2)
            TaskList.adapter = adapter


            GetUserTask()
            //DeleteTask2()
            menuchka.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.addtask -> {

                        AddTaskLauncher!!.launch(
                            Intent(
                                this@MainActivity2,
                                AddTaskScrean::class.java
                            )
                        )
                    }
                    R.id.backscreen -> {
                        val intent = Intent(this@MainActivity2, ScreenSelection::class.java)
                        startActivity(intent)
                        finish()
                    }
                    R.id.completedtasks -> {
                        val intent = Intent(this@MainActivity2, CompletedScreenTask::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                true
            }


        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        when (v!!.getId()) {
            R.id.taskTit -> {
                menu!!.add(0, ID_MOVE_R, 0, R.string.MoveTask2)
                menu!!.add(0, ID_REMOVE, 0, R.string.DeleteTask)

            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var imageictask = listOf(
            R.drawable.ic_iconnext,
            R.drawable.ic_icongreenlvl,
            R.drawable.ic_iconellovlvl,
            R.drawable.ic_iconredlvl,
            R.drawable.ic_iconramk,
            R.drawable.ic_icondelet
        )
        var Drawable = "R.drawable."

        var cod = task2.Day
        var codif = task2.Description
        when (item.itemId) {

            ID_MOVE_R -> {
                if (cod == 7) {
                    Toast.makeText(this, "Невозможно сдвинуть задачу", Toast.LENGTH_SHORT).show()
                } else {
                    if (isNumeric(codif) == true) {
                        when (codif) {
                            "11" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[1],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    2,
                                    "12i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "21" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[2],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    2,
                                    "22i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "31" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[3],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    2,
                                    "32i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "12" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[1],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    3,
                                    "13i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "22" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[2],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    3,
                                    "23i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }

                            "32" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[3],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    3,
                                    "33i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }

                            "13" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[1],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    4,
                                    "14i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "23" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[2],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    4,
                                    "24i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "33" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[3],
                                    imageictask[4],
                                    imageictask[4],
                                    imageictask[4],
                                    2,
                                    "34i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "14" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[1],
                                    imageictask[4],
                                    imageictask[4],
                                    5,
                                    "15i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "24" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[2],
                                    imageictask[4],
                                    imageictask[4],
                                    5,
                                    "25i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "34" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[3],
                                    imageictask[4],
                                    imageictask[4],
                                    5,
                                    "35i"
                                )
                                Move(task2)
                                 UpdateTask(task2)
                            }
                            "15" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[1],
                                    imageictask[4],
                                    6,
                                    "16i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "25" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[2],
                                    imageictask[4],
                                    6,
                                    "26i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "35" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[3],
                                    imageictask[4],
                                    6,
                                    "36i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "16" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[1],
                                    7,
                                    "17i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "26" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[2],
                                    7,
                                    "27i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }
                            "36" -> {
                                task2.Set(
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[0],
                                    imageictask[3],
                                    7,
                                    "37i"
                                )
                                Move(task2)
                                UpdateTask(task2)
                            }


                        }
                    } else {
                        if (ContainD(codif) == true) {
                            Toast.makeText(
                                this,
                                "Ежедневные задачи нельзя передвинуть",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            when (codif) {
                                "12i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[1],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "13i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "22i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[2],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "23i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "32i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[3],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "33i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "13i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[1],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "14i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "23i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[2],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "24i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "33i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[3],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "34i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "14i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[1],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "15i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "24i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[2],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "25i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "34i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[3],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "35i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "15i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[1],
                                        imageictask[4],
                                        6,
                                        "16i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "25i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[2],
                                        imageictask[4],
                                        6,
                                        "26i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "35i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[3],
                                        imageictask[4],
                                        6,
                                        "36i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "16i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[1],
                                        7,
                                        "17i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "26i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[2],
                                        7,
                                        "27i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "36i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[3],
                                        7,
                                        "13i"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                            }
                        }
                    }

                }

            }
            ID_REMOVE -> {
                if (isNumeric(codif) == true) {
                    when (codif) {

                        "11" -> {
                            task2.Set(
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                1,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)

                        }
                        "21" -> {
                            task2.Set(
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                1,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "31" -> {
                            task2.Set(
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                1,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "21" -> {
                            task2.Set(
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                1,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)

                        }
                        "31" -> {
                            task2.Set(
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                1,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "12" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                2,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "22" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                2,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }

                        "32" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                2,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }

                        "13" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                3,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "23" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                3,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "33" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                3,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "14" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                4,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "24" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                4,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "34" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                4,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "15" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                5,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "25" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                5,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "35" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                imageictask[4],
                                5,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "16" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                6,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "26" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                6,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "36" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                imageictask[4],
                                6,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "17" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                7,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "27" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                7,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }
                        "37" -> {
                            task2.Set(
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[4],
                                imageictask[5],
                                7,
                                "Del"
                            )
                            Move(task2)
                            UpdateTask(task2)
                        }

                    }
                } else {
                    if (ContainDD(codif) == true) {

                    } else {
                        if (ContainD(codif) == true) {
                            when (codif) {
                                "D12" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        2,
                                        "D13"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D22" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[2],
                                        imageictask[2],
                                        imageictask[2],
                                        imageictask[2],
                                        imageictask[2],
                                        2,
                                        "D23"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }

                                "D32" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        2,
                                        "D33"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }

                                "D13" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        3,
                                        "D14"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D23" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[2],
                                        imageictask[2],
                                        imageictask[2],
                                        3,
                                        "D24"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D33" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        3,
                                        "D34"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D14" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[1],
                                        imageictask[1],
                                        imageictask[1],
                                        4,
                                        "D15"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D24" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[2],
                                        imageictask[2],
                                        imageictask[2],
                                        4,
                                        "D25"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D34" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[3],
                                        imageictask[3],
                                        imageictask[3],
                                        4,
                                        "D35"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D15" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[1],
                                        imageictask[1],
                                        5,
                                        "D16"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D25" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[2],
                                        imageictask[2],
                                        5,
                                        "D26"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D35" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[3],
                                        imageictask[3],
                                        5,
                                        "D36"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D16" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[1],
                                        6,
                                        "D17"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D26" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[2],
                                        6,
                                        "D27"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D36" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        imageictask[3],
                                        6,
                                        "D37"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D17" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        7,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "D27" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        7,
                                        "Del"

                                    )
                                    Move(task2)
                                    UpdateTask(task2)

                                }
                                "D37" -> {
                                    task2.Set(
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[5],
                                        7,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)

                                }
                            }
                        } else {
                            when (codif) {
                                "12i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        2,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "22i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        2,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }

                                "32i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        2,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }

                                "13i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "23i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "33i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        3,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "14i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "24i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "34i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        imageictask[4],
                                        4,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "15i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "25i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "35i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        imageictask[4],
                                        5,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "16i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        6,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "26i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        6,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "36i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        imageictask[4],
                                        6,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "17i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        7,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "27i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        7,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                                "37i" -> {
                                    task2.Set(
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[0],
                                        imageictask[5],
                                        7,
                                        "Del"
                                    )
                                    Move(task2)
                                    UpdateTask(task2)
                                }
                            }
                        }
                    }
                }
            }

        }
        return super.onContextItemSelected(item)
    }


    override fun onClick(task: AboutTask) {
        binding.taskTit.text = task.NameTask
        task2 = task
        registerForContextMenu(binding.taskTit)


    }

    override fun Move(task: AboutTask) {
        adapter.appLant2()

    }

    fun isNumeric(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun ContainD(s: String): Boolean {
        return s.contains("D")
    }

    fun ContainDD(s: String): Boolean {
        return s.contains("DD")
    }

    private fun insertTask(task: AboutTask) {
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.insert(task = task)
        }
    }
    private fun UpdateTask(task: AboutTask) {
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.update(task = task)
        }
    }
    private fun DeleteTash(task :AboutTask){
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.delete(task = task)
        }
    }
    private fun GetUserTask() {
        lifecycleScope.launch(Dispatchers.IO) {
            var tasks2 = (applicationContext as App).repository.getAllTask()
            withContext(Dispatchers.Main) {
                adapter.setsTask(tasks2)
            }
        }
    }
    private fun DeleteTask2(){
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.DeleteTask()
        }
    }
}