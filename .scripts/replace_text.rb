#!/usr/bin/env ruby

require 'find'

if ARGV.length != 3
  puts "Usage: ruby file.rb <base_dir> <old_text> <new_text>"
  exit 1
end

directory = ARGV[0]
old_text = ARGV[1]
new_text = ARGV[2]

# Check if old_text arg starts with @
# if so try read text from file
if old_text.start_with?('@')
  old_text_filename = old_text[1..]
  if File.exist?(old_text_filename)
    old_text = File.read(old_text_filename)
  end
end

# Check if new_text arg starts with @
# if so try read text from file
if new_text.start_with?('@')
  new_text_filename = new_text[1..]
  if File.exist?(new_text_filename)
    new_text = File.read(new_text_filename)
  end
end

excluded_dirs = ['.git', 'scripts']

Find.find(directory) do |path|
  if FileTest.directory?(path)
    if excluded_dirs.include?(File.basename(path))
      Find.prune
    else
      next
    end
  else
    next unless File.file?(path)

    begin
      content = File.read(path)
      if content.include?(old_text)
        new_content = content.gsub(old_text, new_text)
        File.write(path, new_content)
        puts "Text replaced in: #{path}"
      end
    rescue => e
      puts "Failed to process #{path}: #{e.message}"
    end
  end
end

puts "Replacement completed!"