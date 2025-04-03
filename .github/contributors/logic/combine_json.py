import json

# Load data from the API
with open('.github/contributors/contributors_github_temp.json', 'r') as f:
    api_data = json.load(f)

# Load existing data
with open('.github/contributors/contributors_github.json', 'r') as f:
    existing_data = json.load(f)

# Convert existing data into a dictionary based on login and id
existing_dict = {(user['login'], user['id']): user for user in existing_data}

# Update or add API data
for user in api_data:
    key = (user['login'], user['id'])
    if key in existing_dict:
        # Preserve the existing role if it exists
        if 'role' in existing_dict[key]:
            user['role'] = existing_dict[key]['role']
        existing_dict[key].update(user)
    else:
        existing_dict[key] = user  # Add new users normally

# Convert back to a list
combined_data = list(existing_dict.values())

# Save the combined JSON
with open('.github/contributors/contributors_combined.json', 'w') as f:
    json.dump(combined_data, f, indent=2)
