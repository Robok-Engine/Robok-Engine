# Copyright 2025 Aquiles Trindade (trindadedev).
# Licensed under the Apache 2.0 License.

require 'fileutils'
require 'open-uri'

# Help function
def print_help_and_exit
  puts <<~HELP
    Usage: ruby file.rb <base_dir> [options]
    
    Options:
      -j        Format Java files only
      -k        Format only Kotlin files
      -h        Show help
  HELP
  exit
end

# Argument parsing
if ARGV.empty? || ARGV.include?("-h") || ARGV.length < 2
  print_help_and_exit
end

TO_FORMAT_DIR = ARGV[0]
options = ARGV[1..] || []

FORMAT_JAVA = options.empty? || options.include?("-j")
FORMAT_KOTLIN = options.empty? || options.include?("-k")

CACHE_DIR = "#{ENV['HOME']}/.cache/trindadedev/formatters"
FileUtils.mkdir_p(CACHE_DIR)

FORMATTERS = {
  java: {
    name: "Google Java Formatter",
    file: "google-java-format.jar",
    version: "1.25.2",
    url_template: "https://github.com/google/google-java-format/releases/download/v%{version}/google-java-format-%{version}-all-deps.jar",
    file_ext: "*.java",
    args: ["--replace"]
  },
  kotlin: {
    name: "Facebook KtFmt",
    file: "ktfmt.jar",
    version: "0.53",
    url_template: "https://github.com/facebook/ktfmt/releases/download/v%{version}/ktfmt-%{version}-jar-with-dependencies.jar",
    file_ext: "*.kt",
    args: ["--google-style"]
  }
}

def download_formatter(formatter)
  path = File.join(CACHE_DIR, formatter[:file])
  return path if File.exist?(path)

  puts "Downloading #{formatter[:name]}..."
  url = formatter[:url_template] % { version: formatter[:version] }

  URI.open(url) do |u|
    File.open(path, 'wb') { |f| f.write(u.read) }
  end

  path
end

def format_files(key, formatter)
  jar_path = download_formatter(formatter)
  puts "Formatting files #{key.to_s.capitalize}..."

  files = Dir.glob("#{TO_FORMAT_DIR}/**/#{formatter[:file_ext]}")
  unless files.empty?
    system("java", "-jar", jar_path, *formatter[:args], *files)
  end
end

if FORMAT_JAVA
  format_files(:java, FORMATTERS[:java])
end

if FORMAT_KOTLIN
  format_files(:kotlin, FORMATTERS[:kotlin])
end