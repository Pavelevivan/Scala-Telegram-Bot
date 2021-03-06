package Commands

import main.scala._

case class DeletePoll(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = context => ("Success!", PollRepo(context.polls - id))
}

class Listing extends Command {
  override def execute: PollRepo => (String, PollRepo) = context =>
    (context.polls.values.map(poll => poll.toString).mkString, context)
}

case class StartPoll(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = context =>
    (tryExecute(context.polls, id, _.start), context)
}

case class Result(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = context =>
    (tryExecute(context.polls, id, _.showResult), context)
}

case class StopPoll(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = context =>
    (tryExecute(context.polls, id, _.stop), context)
}

case class Begin(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = context => ("Success!", context)
}

case class DeleteQuestion(id: Int) extends Command {
  override def execute: PollRepo => (String, PollRepo) = { context => ("Success!", context) }
}

class End extends Command {
  override def execute: PollRepo => (String, PollRepo) = { context => ("Success!", context) }
}


class View extends Command {
  override def execute: PollRepo => (String, PollRepo) = { context => ("Success!", context) }
}

case class IncorrectCommand(arg: String) extends Command {
  override def execute: PollRepo => (String, PollRepo) = { context => ("The operation is incorrect", context) }
}

case class AddQuestion(name: String, questionType: Question.Value, answers: Array[String]) extends Command {
  override def execute: PollRepo => (String, PollRepo) = { context => ("Success!", context) }
}