#!/bin/bash

CACHE_DIR="$HOME/.cache/formatters"
mkdir -p "$CACHE_DIR"

# --- Java ---
JAVA_FORMATTER="$CACHE_DIR/google-java-format.jar"

if [ ! -f "$JAVA_FORMATTER" ]; then
    echo "Downloading Google Java Formatter..."
    wget -q "https://github.com/google/google-java-format/releases/download/v1.24.0/google-java-format-1.24.0-all-deps.jar" -O "$JAVA_FORMATTER"
fi

echo "Formatting Java files..."
find ../ -name "*.java" -exec java -jar "$JAVA_FORMATTER" --replace {} +

# --- Kotlin ---
KOTLIN_FORMATTER="$CACHE_DIR/ktfmt.jar"

if [ ! -f "$KOTLIN_FORMATTER" ]; then
    echo "Downloading ktfmt..."
    wget -q "https://github.com/facebook/ktfmt/releases/download/v0.53/ktfmt-0.53-jar-with-dependencies.jar" -O "$KOTLIN_FORMATTER"
fi

echo "Formatting Kotlin files..."
find ../ -name "*.kt" -exec java -jar "$KOTLIN_FORMATTER" --google-style {} +