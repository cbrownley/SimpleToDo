# Pre-work - Simple Todo

Simple Todo is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Clinton Brownley

Time spent: 18 hours spent in total

## User Stories

The following **required** functionality is completed:

* [X] User can **successfully add and remove items** from the todo list
* [X] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [X] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [X] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [X] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [X] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [X] Keep soft keyboard down until user clicks in text area
* [X] Customized splash screen on start up
* [X] Additional Save and Cancel icons in the menu
* [X] Sort list items
* [X] Clear entire list

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='https://github.com/cbrownley/SimpleToDo/blob/master/simple-todo-walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Today I implemented two more of the optional features.  First, I added functionality to the "Add Item" button to persist new todo items into SQLite instead of a text file.  Now the app persists items added with this button to SQLite and displays the items on start up.  I haven't changed the edit and delete sections of code yet, so any edit and delete changes aren't reflected yet.  

Second, I added functionality to use a DialogFragment instead of a new Activity for editing items.  In addition, I added code to keep the soft keyboard down/hidden until the user clicks in the text area to improve the user experience, and I changed the splash screen icon and background color to customize it a little bit more.

Finally, I also organized my Activity files and Database/SQLite files into "activities" and "utils" subfolders to organize my code according to the Android Folder Structure.

Older Notes:
I spent a few hours reading the Android SQLite Help page (https://developer.android.com/training/basics/data-storage/databases.html) and the CodePath SQLite Help page (http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) and trying to implement the first optional feature, persist data to a SQLite database instead of a file.  I haven't gotten it to work yet, but I'm leaving the SQLite-related files in the pre-work submission because I've been working on it and I'm still trying to figure it out (I removed the SQLite-related code from the MainActivity and EditItemActivity to clean up the code for the submission). 

## License

    Copyright 2016 Clinton Brownley

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.