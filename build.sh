git config --global --add safe.directory /home/coder/project
git config --global user.email "you@example.com"
git add --all
git commit -m "commit"
export git_url=$(git remote get-url --push origin) \
&& export github_token=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 \
&&  echo "git push $git_url" | sed -e "s|https://|https://$github_token@|"  | sh
