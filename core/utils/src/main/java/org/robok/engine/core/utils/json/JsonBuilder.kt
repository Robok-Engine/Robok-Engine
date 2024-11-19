package org.robok.engine.core.utils.json

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

import kotlinx.serialization.json.*

class JsonBuilder {
  private val map = mutableMapOf<String, JsonElement>()

  fun property(key: String, value: String) {
    map[key] = JsonPrimitive(value)
  }

  fun property(key: String, value: Number) {
    map[key] = JsonPrimitive(value)
  }

  fun property(key: String, value: Boolean) {
    map[key] = JsonPrimitive(value)
  }

  fun obj(key: String, init: JsonBuilder.() -> Unit) {
    val builder = JsonBuilder().apply(init)
    map[key] = builder.build()
  }

  fun array(key: String, init: JsonArrayBuilder.() -> Unit) {
    val builder = JsonArrayBuilder().apply(init)
    map[key] = builder.build()
  }

  fun build(): JsonObject = JsonObject(map)
}

class JsonArrayBuilder {
  private val list = mutableListOf<JsonElement>()

  fun value(value: String) {
    list.add(JsonPrimitive(value))
  }

  fun value(value: Number) {
    list.add(JsonPrimitive(value))
  }

  fun value(value: Boolean) {
    list.add(JsonPrimitive(value))
  }

  fun obj(init: JsonBuilder.() -> Unit) {
    val builder = JsonBuilder().apply(init)
    list.add(builder.build())
  }

  fun build(): JsonArray = JsonArray(list)
}

fun json(init: JsonBuilder.() -> Unit): JsonObject {
  return JsonBuilder().apply(init).build()
}

fun JsonObject.toStringFormatted(): String = Json {
  prettyPrint = true
}.encodeToString(JsonObject.serializer(), this)