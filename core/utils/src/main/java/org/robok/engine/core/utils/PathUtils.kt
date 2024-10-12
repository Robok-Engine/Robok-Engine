package org.robok.engine.core.utils

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

/*
  Class to help with path management.
  @author Rohit Kushvaha
*/

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.provider.DocumentsContract

object PathUtils {
    @JvmStatic
    fun convertUriToPath(context: Context, uri: Uri?): String {
        val path = internalConvertUriToPath(context, uri)
        return path.replace("/document", "/storage").replace(":", "/")
    }

    private fun internalConvertUriToPath(context: Context, uri: Uri?): String {
        uri?.let {
            when {
                DocumentsContract.isTreeUri(it) -> {
                    // Handle tree URI
                    val docId = DocumentsContract.getTreeDocumentId(it)
                    return when {
                        docId.startsWith("primary:") -> {
                            // Internal storage
                            "${Environment.getExternalStorageDirectory()}/${docId.substringAfter("primary:")}"
                        }

                        else -> {
                            // External storage (SD card)
                            val split = docId.split(":")
                            "/storage/${split[0]}/${split.getOrElse(1) { "" }}"
                        }
                    }
                }

                DocumentsContract.isDocumentUri(context, it) -> {
                    // Handle document URI
                    val docId = DocumentsContract.getDocumentId(it)
                    when {
                        isExternalStorageDocument(it) -> {
                            val split = docId.split(":")
                            val type = split[0]
                            if ("primary".equals(type, ignoreCase = true)) {
                                return "${Environment.getExternalStorageDirectory()}/${
                  split.getOrElse(
                    1
                  ) { "" }
                }"
                            } else {
                                // Handle SD card
                                return "/storage/$type/${split.getOrElse(1) { "" }}"
                            }
                        }

                        isDownloadsDocument(it) -> {
                            val fileName = getFilePath(context, it)
                            if (fileName != null) {
                                return "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)}/$fileName"
                            }
                            // If unable to get the file name, fall back to a default path
                            return "${Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)}/"
                        }

                        isMediaDocument(it) -> {
                            val split = docId.split(":")
                            val type = split[0]
                            var contentUri: Uri? = null
                            when (type) {
                                "image" ->
                                    contentUri =
                                        android.provider.MediaStore.Images.Media
                                            .EXTERNAL_CONTENT_URI

                                "video" ->
                                    contentUri =
                                        android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI

                                "audio" ->
                                    contentUri =
                                        android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                            }
                            val selection = "_id=?"
                            val selectionArgs = arrayOf(split[1])
                            return getDataColumn(context, contentUri, selection, selectionArgs)
                                ?: "/storage/emulated/0/media/"
                        }
                    }
                }

                "content".equals(it.scheme, ignoreCase = true) -> {
                    // Handle content URI
                    return getDataColumn(context, it, null, null) ?: "/storage/emulated/0/"
                }

                "file".equals(it.scheme, ignoreCase = true) -> {
                    // Handle file URI
                    return it.path ?: "/storage/emulated/0/"
                }

                else -> {}
            }
        }
        return "/storage/emulated/0/"
    }

    private fun getDataColumn(
        context: Context,
        uri: Uri?,
        selection: String?,
        selectionArgs: Array<String>?,
    ): String? {
        val column = "_data"
        val projection = arrayOf(column)
        try {
            context.contentResolver.query(uri!!, projection, selection, selectionArgs, null)?.use {
                cursor ->
                if (cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndexOrThrow(column)
                    return cursor.getString(columnIndex)
                }
            }
        } catch (e: Exception) {
            // Log the exception or handle it as needed
        }
        return null
    }

    private fun isExternalStorageDocument(uri: Uri): Boolean {
        return "com.android.externalstorage.documents" == uri.authority
    }

    private fun isDownloadsDocument(uri: Uri): Boolean {
        return "com.android.providers.downloads.documents" == uri.authority
    }

    private fun isMediaDocument(uri: Uri): Boolean {
        return "com.android.providers.media.documents" == uri.authority
    }

    private fun getFilePath(context: Context, uri: Uri): String? {
        try {
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val columnIndex = cursor.getColumnIndex("_display_name")
                    if (columnIndex != -1) {
                        return cursor.getString(columnIndex)
                    }
                }
            }
        } catch (e: Exception) {
            // Log the exception or handle it as needed
        }
        return null
    }
}
