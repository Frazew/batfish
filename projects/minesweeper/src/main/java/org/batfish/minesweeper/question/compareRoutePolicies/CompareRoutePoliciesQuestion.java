package org.batfish.minesweeper.question.compareRoutePolicies;

import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.batfish.datamodel.questions.Question;
import org.batfish.datamodel.routing_policy.Environment;

/** A question for comparing routing policies. */
@ParametersAreNonnullByDefault
public final class CompareRoutePoliciesQuestion extends Question {

  private static final String PROP_DIRECTION = "direction";
  private static final String PROP_POLICY = "policy";
  private static final String PROP_PROPOSED_POLICY = "proposedPolicy";

  private static final String PROP_NODES = "nodes";

  @VisibleForTesting
  static final Environment.Direction DEFAULT_DIRECTION = Environment.Direction.IN;

  @Nonnull private final Environment.Direction _direction;
  @Nullable private final String _policy;
  @Nullable private final String _proposedPolicy;

  @Nullable private final String _nodes;

  public CompareRoutePoliciesQuestion() {
    this(DEFAULT_DIRECTION, null, null, null);
  }

  public CompareRoutePoliciesQuestion(
      Environment.Direction direction,
      @Nullable String policy,
      @Nullable String proposedPolicy,
      @Nullable String nodes) {

    _direction = direction;
    _policy = policy;
    _proposedPolicy = proposedPolicy;
    _nodes = nodes;
  }

  @JsonCreator
  private static CompareRoutePoliciesQuestion jsonCreator(
      @Nullable @JsonProperty(PROP_DIRECTION) Environment.Direction direction,
      @Nullable @JsonProperty(PROP_POLICY) String policy,
      @Nullable @JsonProperty(PROP_PROPOSED_POLICY) String proposedPolicy,
      @Nullable @JsonProperty(PROP_NODES) String nodes) {
    return new CompareRoutePoliciesQuestion(
        firstNonNull(direction, DEFAULT_DIRECTION), policy, proposedPolicy, nodes);
  }

  @JsonIgnore
  @Override
  public boolean getDataPlane() {
    return false;
  }

  @JsonProperty(PROP_DIRECTION)
  @Nonnull
  public Environment.Direction getDirection() {
    return _direction;
  }

  @JsonIgnore
  @Nonnull
  @Override
  public String getName() {
    return "compareRoutePolicies";
  }

  @Nullable
  @JsonProperty(PROP_POLICY)
  public String getPolicy() {
    return _policy;
  }

  @Nullable
  @JsonProperty(PROP_PROPOSED_POLICY)
  public String getProposedPolicy() {
    return _proposedPolicy;
  }

  @Nullable
  @JsonProperty(PROP_NODES)
  public String getNodes() {
    return _nodes;
  }
}
